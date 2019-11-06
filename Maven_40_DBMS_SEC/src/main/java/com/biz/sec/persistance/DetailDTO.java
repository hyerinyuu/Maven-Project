package com.biz.sec.persistance;

import lombok.ToString;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DetailDTO {

	private long d_seq;
	private long d_m_seq; // tbl_master와 연계(relation)을 수행하는 key(FK)
	private String d_subject;
	private String d_ok;
}
