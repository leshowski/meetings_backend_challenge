package com.globant.challenge.jci.model.dto.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.globant.challenge.jci.model.entity.Capability;
import com.globant.challenge.jci.model.entity.Floor;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class JsonRoom {

  @JsonProperty("code")
  private Long code;
  @JsonProperty("name")
  private String name;

  @JsonProperty("max_allocation")
  private int maxAllocation;

  @JsonProperty("capabilities")
  private Map<Long,String> capabilities;

}
