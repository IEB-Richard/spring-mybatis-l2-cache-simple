package tk.mybatis.simple.model;

public class Country {
	private Long id;
	private String countryname;
	private String countrycode;

	public Country() {
	}

	public Country(Long id, String countryname, String countrycode) {
		this.id = id;
		this.countryname = countryname;
		this.countrycode = countrycode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countrycode == null) ? 0 : countrycode.hashCode());
		result = prime * result + ((countryname == null) ? 0 : countryname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
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
		if (countrycode == null) {
			if (other.countrycode != null)
				return false;
		} else if (!countrycode.equals(other.countrycode))
			return false;
		if (countryname == null) {
			if (other.countryname != null)
				return false;
		} else if (!countryname.equals(other.countryname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", countryname=" + countryname + ", countrycode=" + countrycode + "]";
	}

	
}
