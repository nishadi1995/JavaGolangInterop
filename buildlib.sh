go build -o mylib.so -buildmode=c-shared mylib.go
cp mylib.so JavaGolangInterop/src/main/resources/lib/x64/
