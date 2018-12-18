 version=$(git rev-parse --short HEAD)
 PNAME=$(echo $JOB_NAME | tr / . | tr "[:upper:]" "[:lower:]")
PACKAGENAME=${PNAME%.*}
echo $PACKAGENAME
docker build -t adilforms/$PACKAGENAME.$version:$BRANCH_NAME .
