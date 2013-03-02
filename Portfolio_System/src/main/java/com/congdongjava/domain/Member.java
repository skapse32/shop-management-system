package com.congdongjava.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@NamedQueries({
	@NamedQuery(name = "Member.findAll", query = "SELECT m FROM Member m") })
public class Member implements Serializable
{
   /** Default value included to remove warning. Remove or modify at will. **/
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name = "member_id")
   private Long memberId;

   @NotNull
   @Size(min = 1, max = 25)
   @Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
   private String name;

   @NotNull
   @NotEmpty
   @Email
   private String email;

   @NotNull
   @Size(min = 10, max = 12)
   @Digits(fraction = 0, integer = 12)
   @Column(name = "phone_number")
   private String phoneNumber;

   public Long getMemberId() {
      return memberId;
   }

   public void setMemberId(final Long memberId) {
      this.memberId = memberId;
   }

   public String getName() {
      return name;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(final String email) {
      this.email = email;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(final String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }
}