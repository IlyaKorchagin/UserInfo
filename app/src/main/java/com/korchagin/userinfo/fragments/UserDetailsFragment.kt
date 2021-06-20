package com.korchagin.userinfo.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.korchagin.userinfo.R
import com.korchagin.userinfo.model.People
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class UserDetailsFragment : Fragment() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_user_details, container, false)
        val bundle = arguments
        val formatter: DateTimeFormatter
        if (bundle != null) {
            val details = bundle.getSerializable("CUR_USER")
            val people: People = details as People

            val textName: TextView = view.findViewById(R.id.tv_UserName)
            textName.text = people.name.toLowerCase().capitalize()

            val textSurname: TextView = view.findViewById(R.id.tv_UserSurname)
            textSurname.text = people.surname.toLowerCase().capitalize()

            val textAge: TextView = view.findViewById(R.id.tv_UserAge)
            val userBirthday = Calendar.getInstance()
            val today = Calendar.getInstance()
            var str = people.birthday
            if (str !="") {
                str?.let {
                    val checkFormat = str.substringBefore("-")
                    if (checkFormat.length > 2) {
                        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                    } else {
                        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
                    }

                    val dateTime = LocalDate.parse(str, formatter)

                    userBirthday.set(dateTime.year, dateTime.monthValue, dateTime.dayOfMonth)

                    var age = today.get(Calendar.YEAR) - dateTime.year

                    if (today.get(Calendar.DAY_OF_YEAR) < dateTime.dayOfYear) {
                        age--
                    }
                    textAge.text = "возраст: $age"
                }
            }

            val userImage: ImageView = view.findViewById(R.id.iv_UserAvatar)
            people.avatar_url?.let {
                Glide.with(view.context)
                    .load(people.avatar_url)
                    .into(userImage);
            }

            val textSpecialty: TextView = view.findViewById(R.id.tv_UserSpecialty)
            textSpecialty.text = people.company
        }
    return view
    }
}