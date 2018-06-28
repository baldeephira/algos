#!/bin/bash

CLASSPATH="."

echo ""
echo "building algos..."

# cleaning up dist folder
echo "cleaning up dist folder"
rm dist/*.class

# compile java file
cd src
javac -cp $CLASSPATH *.java

# move class file to dist
echo "move class files to dist"
mv *.class ../dist

# return to base dir
cd ..
echo "build finished!!!"
echo ""
