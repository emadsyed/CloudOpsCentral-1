def call(Map config) {

 node ('master'){
  try{
  
stage('Checkout'){
 checkout scm 
}
stage('Build'){
 def pacakgename = libraryResource 'dockerImageName.sh'
 sh packagename
 def install = libraryResource 'dockerBuild.sh'
 sh install
    echo 'building'
    sh 'npm install'
 
}
stage('Test'){ 
    echo 'version' 
 }
 
stage('Publish') { 
def request = libraryResource 'dockerPush.sh'
 sh request
 }
stage('PostAction') {
   echo "Cleaning Work Space"
    deleteDir()  
  }
   return true
   echo "Success"
  
  }
  catch (err){
      echo "Failed"
   return false
   }

  
  
}
 }

