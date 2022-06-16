
# 不要轻易执行
git_push(){
    git push -f origin main
    if [ $? -eq 0 ]; then
        echo "succeed"
    else
        git_push -f origin main
    fi  
}
git_push