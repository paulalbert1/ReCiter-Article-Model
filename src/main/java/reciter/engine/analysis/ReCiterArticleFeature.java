package reciter.engine.analysis;

import lombok.Data;
import reciter.engine.analysis.evidence.Evidence;
import reciter.model.pubmed.MedlineCitationJournalISSN;

import java.util.Date;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel.DynamoDBAttributeType;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;
import com.fasterxml.jackson.annotation.JsonInclude;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@DynamoDBDocument
public class ReCiterArticleFeature {
    private long pmid;
    private String pmcid;
    private double totalArticleScoreStandardized;
    private double totalArticleScoreNonStandardized;
    @DynamoDBTyped(DynamoDBAttributeType.S)
    private PublicationFeedback userAssertion;
    private String publicationDateDisplay;
    private String publicationDateStandardized;
    private String datePublicationAddedToEntrez;
    private String doi;
    private ReCiterArticlePublicationType publicationType;
    private Long timesCited;
    private String publicationAbstract;
    private String scopusDocID;
    private String journalTitleVerbose;
    private List<MedlineCitationJournalISSN> issn;
    private String journalTitleISOabbreviation;
    private String articleTitle;
    private List<ReCiterArticleAuthorFeature> reCiterArticleAuthorFeatures;
    private String volume;
    private String issue;
    private String pages;
    private Evidence evidence;
    
    public enum PublicationFeedback {
		ACCEPTED, // This publication is in the gold standard
		REJECTED, // This publications was rejected 
		NULL // No action
	}
}
