
      # arg $1 is "repo/packageName.version:branchName"
      echo "Building image..."
      docker build -t adilforms/$PACKAGENAME.$version:$BRANCH_NAME .
  
