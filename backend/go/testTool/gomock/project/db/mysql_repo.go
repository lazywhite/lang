package db
import (
	"fmt"
)

type MysqlRepo struct{
	Host string
	Port int
}

func (m *MysqlRepo) Create(key string, value []byte) error {
	fmt.Printf("create method: key: %s, value: %s\n", key, string(value))
	return nil
}

func (m *MysqlRepo) Retrieve(key string) ([]byte, error) {
	fmt.Printf("retrive method: key: %s\n", key)
	return []byte("a string"), nil
}

func (m *MysqlRepo) Update(key string, value []byte) error {
	fmt.Printf("update method: key: %s, value: %s\n", key, string(value))
	return nil
}

func (m *MysqlRepo) Delete(key string) error {
	fmt.Printf("delete method: key: %s\n", key)
	return nil
}
