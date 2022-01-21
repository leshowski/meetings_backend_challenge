package com.globant.challenge.jci.model.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Builder
public class Room {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @OneToOne(fetch = FetchType.LAZY)
  private Floor floor;

  private int maxAllocation;

  @JoinTable(
      name = "rel_room_capability",
      joinColumns = @JoinColumn(name = "FK_ROOM", nullable = false),
      inverseJoinColumns = @JoinColumn(name="FK_CAPABILITY", nullable = false)
  )
  @ManyToMany
  private List<Capability> capabilities;


}
