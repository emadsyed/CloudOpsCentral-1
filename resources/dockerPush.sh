    # arg $1 is "repo/packageName.version:branchName"
      echo "Publishing..."
      #docker push $1
      docker push adilforms/$PACKAGENAME.$version:$BRANCH_NAME
