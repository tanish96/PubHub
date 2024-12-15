{\rtf1\ansi\ansicpg1252\cocoartf2639
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fnil\fcharset0 HelveticaNeue-Bold;\f1\fnil\fcharset0 HelveticaNeue;}
{\colortbl;\red255\green255\blue255;\red220\green161\blue13;}
{\*\expandedcolortbl;;\cssrgb\c89412\c68627\c3922;}
\paperw11900\paperh16840\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\deftab560
\pard\pardeftab560\partightenfactor0

\f0\b\fs40 \cf0 /* - Fragments */\
\pard\pardeftab560\slleading20\partightenfactor0

\f1\b0\fs26 \cf0 \
\
Val buttonClock = findViewById<Button>({\field{\*\fldinst{HYPERLINK "http://R.id"}}{\fldrslt \cf2 R.id}}.btn_Time)\
Val buttonExam = findViewById<Button>({\field{\*\fldinst{HYPERLINK "http://R.id"}}{\fldrslt \cf2 R.id}}.btn_Exam)\
\
buttonClock.setOnClickListener\{\
     replaceFragmentWithFragment(Clock_fragment())\
\}\
\
buttonExam.setOnClickListener\{\
     replaceFragmentWithFragment(Exam_Fragment())\
   \
\}\
\pard\pardeftab560\slleading20\pardirnatural\partightenfactor0
\cf0 \
\
\pard\pardeftab560\slleading20\partightenfactor0
\cf0 //This is the function for fragments \
Private fun replaceFragmentWithFragment(frag: Fragment)\{\
\pard\pardeftab560\slleading20\pardirnatural\partightenfactor0
\cf0 \
\pard\pardeftab560\slleading20\partightenfactor0
\cf0   Val fragManager = supportFragmentManager\
  Val fragTransaction= fragManager.beginTransaction()\
  fragTransaction.replace({\field{\*\fldinst{HYPERLINK "http://R.id"}}{\fldrslt \cf2 R.id}}.frameLayout, frag)\
 fragTransaction.commit()\
\pard\pardeftab560\slleading20\pardirnatural\partightenfactor0
\cf0 \
\pard\pardeftab560\slleading20\partightenfactor0
\cf0 \}}