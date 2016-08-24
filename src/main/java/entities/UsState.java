package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "us_states")
public class UsState {
    @Id
    @Column(name = "us_state_id")
    private Long usStateId;
    @Column(name="us_state_cd")
    private String usStateCd;
    @Column(name="us_state_nm")
    private String usStateNm;

    public Long getUsStateId() {
        return usStateId;
    }

    public void setUsStateId(Long usStateId) {
        this.usStateId = usStateId;
    }

    public String getUsStateCd() {
        return usStateCd;
    }

    public void setUsStateCd(String usStateCd) {
        this.usStateCd = usStateCd;
    }

    public String getUsStateNm() {
        return usStateNm;
    }

    public void setUsStateNm(String usStateNm) {
        this.usStateNm = usStateNm;
    }
}

