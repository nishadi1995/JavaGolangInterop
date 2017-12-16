package main

import (
	"testing"
	"fmt"
)

func Test_Base64(t *testing.T){
	fmt.Printf("%s \n",Base64("Hello"))
}