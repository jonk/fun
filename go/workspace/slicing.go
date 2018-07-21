package main

import "fmt"

func main() {
    var declTest []int 
    makeTest := make([]int, 0)
    fmt.Println(len(makeTest))
    fmt.Println(len(declTest))
    fmt.Println(makeTest == nil)
    fmt.Println(declTest == nil)
    a := append(makeTest, 1)
    b := append(declTest, 1)
    fmt.Println(a)
    fmt.Println(b)
}