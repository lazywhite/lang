package db

import (
   "testing"
   "fmt"
   "github.com/golang/mock/gomock"
   "demo/mock/db"
   "github.com/stretchr/testify/assert"
)
 
func TestMySQL_CreateData(t *testing.T) {
   ctr := gomock.NewController(t)
   defer ctr.Finish()
   var key string = "Hello"
   var value []byte = []byte("Go")
   mockRepository := mock_db.NewMockRepository(ctr)
   gomock.InOrder(
      mockRepository.EXPECT().Create(key, value).Return(nil),
   )
   mySQL := NewMySQL(mockRepository)
   err := mySQL.CreateData(key, value)
   if err != nil {
      fmt.Println(err)
   }
}
 
func TestMySQL_GetData(t *testing.T) {
   ctr := gomock.NewController(t)
   defer ctr.Finish()
   var key string = "Hello"
   var value []byte = []byte("Go")
   mockRepository := mock_db.NewMockRepository(ctr)
   gomock.InOrder(
      mockRepository.EXPECT().Retrieve(key).Return(value, nil),
   )
   mySQL := NewMySQL(mockRepository)
   bytes, err := mySQL.GetData(key)
   if err != nil {
      fmt.Println(err)
   } else {
      assert.Equal(t, string(bytes), "Go", "should be equal")
   }
}
 
func TestMySQL_UpdateData(t *testing.T) {
   ctr := gomock.NewController(t)
   defer ctr.Finish()
   var key string = "Hello"
   var value []byte = []byte("Go")
   mockRepository := mock_db.NewMockRepository(ctr)
   gomock.InOrder(
      mockRepository.EXPECT().Update(key, value).Return(nil),
   )
   mySQL := NewMySQL(mockRepository)
   err := mySQL.UpdateData(key, value)
   if err != nil {
      fmt.Println(err)
   }
}
 
func TestMySQL_DeleteData(t *testing.T) {
   ctr := gomock.NewController(t)
   defer ctr.Finish()
   var key string = "Hello"
   mockRepository := mock_db.NewMockRepository(ctr)
   gomock.InOrder(
      mockRepository.EXPECT().Delete(key).Return(nil),
   )
   mySQL := NewMySQL(mockRepository)
   err := mySQL.DeleteData(key)
   if err != nil {
      fmt.Println(err)
   }

}
