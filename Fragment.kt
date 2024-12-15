/* - Fragments */


Val buttonClock = findViewById<Button>(R.id.btn_Time)
Val buttonExam = findViewById<Button>(R.id.btn_Exam)

buttonClock.setOnClickListener{
     replaceFragmentWithFragment(Clock_fragment())
}

buttonExam.setOnClickListener{
     replaceFragmentWithFragment(Exam_Fragment())
   
}


//This is the function for fragments 
Private fun replaceFragmentWithFragment(frag: Fragment){

  Val fragManager = supportFragmentManager
  Val fragTransaction= fragManager.beginTransaction()
  fragTransaction.replace(R.id.frameLayout, frag)
 fragTransaction.commit()

}
https://www.geeksforgeeks.org/android-projects-from-basic-to-advanced-level/
