package edu.miu.cs.cs425.studentmgmt.model;

import jakarta.persistence.*;

@Entity
@Table(name = "transcripts")
public class Transcript {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transcriptId;

    @Column(nullable = false)
    private String degreeTitle;

    public Transcript() {}

    public Transcript(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

	public Long getTranscriptId() {
		return transcriptId;
	}

	public void setTranscriptId(Long transcriptId) {
		this.transcriptId = transcriptId;
	}

	public String getDegreeTitle() {
		return degreeTitle;
	}

	public void setDegreeTitle(String degreeTitle) {
		this.degreeTitle = degreeTitle;
	}

	@Override
	public String toString() {
		return "Transcript [transcriptId=" + transcriptId + ", degreeTitle=" + degreeTitle + "]";
	}

    // Getters and Setters
}
