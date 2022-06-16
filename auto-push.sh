
# 提交至暂存区
git add .
# 提交至本地仓库
git commit -m auto:$1

# 因为网络原因，GitHub 需要多次提交才能完成
git_push(){
    git push
    if [ $? -eq 0 ]; then
        echo "succeed"
    else
        git_push
    fi  
}

# 提交至网络仓库
git_push

