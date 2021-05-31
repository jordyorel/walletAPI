package com.example.wallet;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Card {
    //TODO: print error message 
    @Id
    @Size(min = 16, max = 16, message = "Credit card number must be 16 digits")
    @CreditCardNumber(ignoreNonDigitCharacters = true, message = "Enter a valid credit card number")
    private String cardNumber;

    //TODO: print error message
    @DateTimeFormat(pattern = "yyyy/MM")
    private Date expireDate;
    
    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    Card(){}

    // public  Card(String cardNumber, Date expireDate, User user) {
    //     this.cardNumber = cardNumber;
    //     this.expireDate = expireDate;
    //     this.user = user;
    // }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
