
   //    def proc = ['bash', '-c', PACKAGENAME].execute()
    //   proc.waitFor()
    //println proc.text
       
     
//def Version = sh ' git rev-parse --short HEAD)'
//Version()




def call(Map config) {
 
 node ('master'){

   deleteDir()
  try{
         
 stage('Checkout'){
 checkout scm  
   
      }

stage('Build'){

    echo 'building'
   
    
// executeShellCommand(command)
   
    sh 'npm install'
// def artifactname = libraryResource 'dockerImageName.sh'
 //sh artifactname

 
}
stage('Test'){ 
    echo 'version' 
 }
 
stage('Publish') { 
def request = libraryResource 'dockerPush.sh'
  
 sh request
 }
stage('PostAction') {
       echo "Sending Email"

    
  }
   echo "Success"
   return true
   
  
  }
  catch (err){
      echo "Failed"
    currentBuild.result = 'FAILED'
   throw err
   }

  
  
}
 }


