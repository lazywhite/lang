package app

import (
	. "github.com/onsi/ginkgo"
	. "github.com/onsi/gomega"
)

var _ = Describe("Lib", func() {
	var (
		firstName string
		lastName string
	)
	BeforeEach(func(){
		firstName = "Donald"
		lastName = "Trump"
		By("before each 01")
	})
	JustBeforeEach(func(){
		By("just before each 01")
	})

	AfterEach(func(){
		By("after each 01")
	})

	JustAfterEach(func(){
		By("just after each 01")
	})


	Context("context 02", func(){
		BeforeEach(func(){
			By("before each 02")
		})
		JustBeforeEach(func(){
			By("just before each 02")
		})

		AfterEach(func(){
			By("after each 02")
		})

		JustAfterEach(func(){
			By("just after each 02")
		})
		Context("context 03", func(){
			CurrentGinkgoTestDescription()
			It("should be Donald Trump", func(){
				//Expect(FullName(firstName, lastName)).To(Equal("Donald J. Trump"))
				Expect(FullName(firstName, lastName)).To(Equal("Donald Trump"))
				//Fail("not working")
			})
		})
	})
})
