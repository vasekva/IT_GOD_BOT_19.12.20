package ru.sberbank.itgod.mechanics;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

@Data
public class Team {

	@SerializedName("TeamId")
	private String teamId;
	@SerializedName("Players")
	private List<TeamPlayer> players;

	public Team(String teamId, List<TeamPlayer> players) {
		if (teamId == null)
			throw new IllegalArgumentException("Team id is null");
		if (CollectionUtils.isEmpty(players))
			throw new IllegalArgumentException("Players is null");
		this.players = players;
		this.teamId = teamId;
	}
}
