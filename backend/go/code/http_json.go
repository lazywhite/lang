package main

import (
	"bytes"
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"
)

type SelfDefineRiskRequest struct {
	RiskGradeTemplate string            `json:"riskGradeTemplate,omitempty"`
	TemplateInput     map[string]string `json:"templateInput,omitempty"`
}

type RiskInfo struct {
	Runtime     string `json:"runtime,omitempty"`
	Level       string `json:"level,omitempty"`
	Description string `json:"description,omitempty"`
	Last        string `json:"last,omitempty"`
	Current     string `json:"current,omitempty"`
	Owner       string `json:"owner,omitempty"`
	Item        string `json:"item,omitempty"`
}

func main() {
	url := "http://localhost:6000/v1/self_define/last"
	fmt.Println("URL:>", url)

	reqData := SelfDefineRiskRequest{
		RiskGradeTemplate: "riskgrade-sample",
		TemplateInput: map[string]string{
			"stsName":         "redis-middleware",
			"stsNamespace":    "default",
			"cpuRequestLevel": "low",
			"diffWithType":    "minio",
			"diffWithPath":    "local/middleware",
		},
	}

	jsonStr, err := json.Marshal(reqData)
	if err != nil {
		fmt.Println("json marshal error")
	}

	req, err := http.NewRequest("POST", url, bytes.NewBuffer(jsonStr))
	req.Header.Set("Content-Type", "application/json")

	client := &http.Client{}
	resp, err := client.Do(req)
	if err != nil {
		panic(err)
	}
	defer resp.Body.Close()

	fmt.Println("response Status:", resp.Status)
	fmt.Println("response Headers:", resp.Header)
	body, _ := ioutil.ReadAll(resp.Body)
	fmt.Println("response Body:", string(body))

	var x []RiskInfo
	json.Unmarshal(body, &x)
	fmt.Println(x)
}
