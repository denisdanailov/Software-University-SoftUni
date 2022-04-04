package com.example.football.models.dto.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "stats")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateStatsFactory {

    @XmlElement(name = "stat")
    private List<CreateStatDTO> stats;

    public List<CreateStatDTO> getStats() {
        return stats;
    }
}
