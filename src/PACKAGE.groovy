def PACKAGENAME () {
    '''
       version=$(git rev-parse --short HEAD)
       PNAME=$(echo $JOB_NAME | tr / . | tr "[:upper:]" "[:lower:]")
       PACKAGENAME=${PNAME%.*}
       echo $PACKAGENAME
                  '''
    return true
}
def PACK {
['bash', '-c', PACKAGENAME].execute()
       PACK.waitFor()
    println PACK.text
    
    return true
    }
