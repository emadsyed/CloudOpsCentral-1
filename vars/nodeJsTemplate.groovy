def dockerfile = readfile libraryResource 'DOCKERFILE'


def call(Map config) {

 node ('master'){
  deleteDir()
  try{
  
stage('Checkout'){
 checkout scm  // In this Step Jenkins will get the Git Url and Branch name from the job.
  //def dockerfile = libraryResource 'dockerfilepull.sh' // Reading Docker function to Copy Docker file.
 //sh  dockerfile  
 sh ' echo $dockerfile >> Dockerfile'
 
}
stage('Build'){
 
    echo 'building'
    sh 'npm install'
 //def artifactname = libraryResource 'dockerBuild.sh'
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
   echo "Cleaning WorkSpace"
    deleteDir()  
  }
   echo "Success"
   return true
   
  
  }
  catch (err){
      echo "Failed"
   throw err
   }

  
  
}
 }

