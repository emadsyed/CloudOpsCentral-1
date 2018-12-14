 version=$(git rev-parse --short HEAD)
      P_Name=$(echo $JOB_NAME | tr / . | tr "[:upper:]" "[:lower:]")
      Package_Name=${PNAME%.*}
      echo "adilforms/$Package_Name.$version:$BRANCH_NAME"
