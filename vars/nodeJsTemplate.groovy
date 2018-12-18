def PACKAGENAME = '''
 version=$(git rev-parse --short HEAD)
 PNAME=$(echo $JOB_NAME | tr / . | tr "[:upper:]" "[:lower:]")
 PACKAGENAME=${PNAME%.*}
 echo $PACKAGENAME
'''
def proc = ['bash', '-c', PACKAGENAME].execute()
//proc.waitFor()
//println proc.text

def call(Map config(PACKAGENAME)) {
 node ('master'){
  try{
  
stage('Checkout'){
 checkout scm 
 echo PACkAGENAME
 // def dockerfile = libraryResource 'dockerBuild.sh'
// sh dockerfile


 
}
stage('Build'){
 
    echo 'building'
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


