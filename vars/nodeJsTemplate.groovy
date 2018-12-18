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
// def artifactname = libraryResource 'dockerImageName.sh'
 //sh artifactname
 def proc = ['bash', '-c', command].execute()
proc.waitFor()
println proc.text
 
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

def command ='''

  version=$(git rev-parse --short HEAD)
 PNAME=$(echo $JOB_NAME | tr / . | tr "[:upper:]" "[:lower:]")
PACKAGENAME=${PNAME%.*}
echo $PACKAGENAME.$version
 //docker build -t adilforms/$PACKAGENAME.$version:$BRANCH_NAME .
  
  '''

