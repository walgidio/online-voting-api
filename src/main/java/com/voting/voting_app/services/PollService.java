package com.voting.voting_app.services;

import com.voting.voting_app.models.Poll;
import com.voting.voting_app.models.Vote;
import com.voting.voting_app.models.VoteOption;
import com.voting.voting_app.repositories.PollRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollService {
    private final PollRepository pollRepository;

    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    public Poll createPoll(Poll poll) {
        return pollRepository.save(poll);
    }

    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    public Optional<Poll> getPollById(Long id) {
        return pollRepository.findById(id);
    }

    public void vote(Long pollId, int optionIndex) {
        Poll poll = pollRepository.findById(pollId)
                .orElseThrow(() -> new RuntimeException("Poll Not Found"));
        List<VoteOption> optionList= poll.getOptions();
        if (optionIndex < 0 || optionIndex >= optionList.size()) {
            throw new IllegalArgumentException("Invalid option index");
        }

        VoteOption selectedOption = optionList.get(optionIndex);
        selectedOption.setVoteCount(selectedOption.getVoteCount() + 1);
        pollRepository.save(poll);
    }

    public void deletePollById(Long id) {
        pollRepository.deleteById(id);
    }
}
