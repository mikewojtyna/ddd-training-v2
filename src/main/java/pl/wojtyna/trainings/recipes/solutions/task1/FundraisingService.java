package pl.wojtyna.trainings.recipes.solutions.task1;

public interface FundraisingService {

    ProposalDraft createProposalDraft(ProposalDraftData proposalDraftData);

    Proposal proposeProject(ProposalDraft proposalDraft);

    AcceptedProposal acceptProposalForVerification(Proposal proposal);

    AcceptedProposal acceptProposal(Proposal proposal);

    RejectedProposal rejectProposal(Proposal proposal);

    Fundraising startFundraising(Proposal proposal);

    void cancelProjectFundraising(Fundraising fundraising);

    void depositInto(Fundraising fundraising);

    Project releaseFundsFor(Fundraising fundraising);
}
