package com.codewithandro.photoframeapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class PhotoFrame : AppCompatActivity() {

    var currentImage=0
    lateinit var image: ImageView

    var title= arrayOf("Tony Stark"," Virat Kohli ","MS Dhoni","Leonardo DiCaprio","Joaquin Phoenix","Elon Musk","Bill Gates")
    var desc= arrayOf(
        "Everyone Wants A Happy Ending, Right? But It Doesn't Always Roll That Way" ,
        "Self belief & hard work will always earn you success",
        "Face the failure, until the failure fails to face you",
        "if you have done your best you can. worrying wont make it any better. If you want to be successful, respect one rule - Never let failures take control of you",
        "It's hard for me to put my feelings into words",
        "I think it is possible for ordinary people to choose to be extraordinary.",
        "We all need people who will give us feedback"
        )

    @SuppressLint("DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_photo_frame)

        val preBtn=findViewById<ImageButton>(R.id.preBtn)
        val nextBtn=findViewById<ImageButton>(R.id.nextBtn)

        val tvTitle=findViewById<TextView>(R.id.t1)
        val tvDes=findViewById<TextView>(R.id.d1)

        preBtn.setOnClickListener{

            val idCurrentImageString = "p$currentImage"//id+inc  <- xml id

            //convert string id into integer address associated with it
            //featch pre positionString                           ! 1-> kis id ko convert karna hai simple convert
            val idCurrentImageInt =this.resources.getIdentifier(idCurrentImageString ,"id",packageName)//adderess featch pre image ka

            image=findViewById(idCurrentImageInt)
            image.alpha= 0f

            currentImage= (7 + currentImage - 1 ) % 7 //pre image

            val idImageToShowString ="p$currentImage"
            //convert string id into integer address associated with it
            //featch pre position
            val idImageToShowInt =this.resources.getIdentifier(idImageToShowString,"id",packageName)

            image=findViewById(idImageToShowInt)
            image.alpha=1f

            //show new text incress
            tvTitle.text =title[currentImage]
            tvDes.text =desc[currentImage]
        }

        //simple (-) <- ( +)  bas nextBtn only change

        nextBtn.setOnClickListener{

            val idCurrentImageString = "p$currentImage"
            //convert string id into integer address associated with it
            //featch pre position
            val idCurrentImageInt =this.resources.getIdentifier(idCurrentImageString,"id",packageName)

            image=findViewById(idCurrentImageInt)
            image.alpha=0f

            currentImage= (7 + currentImage + 1 ) % 7 //next image

            val idImageToShowString ="p$currentImage"
            //convert string id into integer address associated with it
            //featch pre position
            val idImageToShowInt =this.resources.getIdentifier(idImageToShowString,"id",packageName)

            image=findViewById(idImageToShowInt)
            image.alpha=1f

            //show new text incress
            tvTitle.text =title[currentImage]
            tvDes.text =desc[currentImage]
        }

    }
}