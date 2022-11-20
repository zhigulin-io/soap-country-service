package ru.jigulin.soap.countryclient.country;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ru.jigulin.soap.countryclient.currency.Currency;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Column(name = "country_code", unique = true, nullable = false)
    private String code;

    @Column(name = "country_name")
    private String name;
    
    @Column(name = "capital_name")
    private String capital;
    
    @Column(name = "phone_code")
    private String phoneCode;
    
    @Column(name = "flag_link")
    private String flagLink;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency_code", insertable = false, updatable = false)
    private Currency currency;
    
    @Column(name = "currency_code")
    private String currencyCode;
    
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getPhoneCode() {
		return phoneCode;
	}

	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}

	public String getFlagLink() {
		return flagLink;
	}

	public void setFlagLink(String flagLink) {
		this.flagLink = flagLink;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(capital, code, currencyCode, flagLink, name, phoneCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return Objects.equals(capital, other.capital) && Objects.equals(code, other.code)
				&& Objects.equals(currencyCode, other.currencyCode) && Objects.equals(flagLink, other.flagLink)
				&& Objects.equals(name, other.name) && Objects.equals(phoneCode, other.phoneCode);
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + ", capital=" + capital + ", phoneCode=" + phoneCode
				+ ", flagLink=" + flagLink + ", currencyCode=" + currencyCode + "]";
	}
}
