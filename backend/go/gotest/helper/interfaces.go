package helper

type Shape interface{
	Area() float32
}

func GetArea(s Shape) float32 {
	return s.Area()
}
