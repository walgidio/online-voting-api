package com.voting.voting_app.models;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class VoteOption {
    private String voteOption;
    private Long voteCount = 0L;
}
