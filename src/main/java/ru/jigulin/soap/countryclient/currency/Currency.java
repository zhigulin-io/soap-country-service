package ru.jigulin.soap.countryclient.currency;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "currencies")
public class Currency {

    @Id
    @Column(name = "currency_code", unique = true, nullable = false)
    private String code;

    @Column(name = "currency_name")
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return code.equals(currency.code) && name.equals(currency.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name);
    }

	@Override
	public String toString() {
		return "Currency [code=" + code + ", name=" + name + "]";
	}
}
