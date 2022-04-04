package com.example.football.models.dto.xml;

import com.example.football.models.entity.Player;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "players")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreatePlayersFactory {

    @XmlElement(name = "player")
    private List<CreatePlayerDTO> players;

    public List<CreatePlayerDTO> getPlayers() {
        return players;
    }
}
