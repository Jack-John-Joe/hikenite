#!/bin/bash

src_dir="./src/"
classes_dir="./classes/"

# Find all Java files in the source directory and its subdirectories
java_files=($(find "$src_dir" -type f -name "*.java"))

# Compile each Java file and place the class files in the destination directory
for java_file in "${java_files[@]}"; do
    class_file="$classes_dir${java_file#$src_dir}"
    class_file="${class_file%.java}.class"
    mkdir -p "$(dirname "$class_file")"
    javac -d "$classes_dir" "$java_file"
    if [ $? -ne 0 ]; then
        echo "Error compiling $java_file"
    fi
done

echo "compiled up"
echo "oh and this script is bad so you have to manually put the classes into the folders and add the yaml and py files in yourself :middlefinger:"
