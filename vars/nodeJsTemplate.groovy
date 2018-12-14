def call(Map config) {

 node ('master'){
  try{
  
stage('Checkout'){
 checkout scm 
  def dockerfile = libraryResource 'dockerBuild.sh'
 sh dockerfile
 
}
stage('Build'){
 
    echo 'building'
    sh 'npm install'
 def artifactname = libraryResource 'dockerImageName.sh'
 sh artifactname
 
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

