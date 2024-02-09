package com.app.modal;

import java.util.List;

import lombok.Data;

@Data
public class RespDTO {
	private int count;
	private List<Entry> entries;
}
