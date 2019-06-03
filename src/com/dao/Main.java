package com.dao;

import java.util.Date;

import javax.swing.JOptionPane;

import org.springframework.stereotype.Component;

@Component
public class Main {
	public static void main(String[] args) {
		Date date=new Date();
		JOptionPane.showConfirmDialog(null, "确认删除?", "标题", JOptionPane.YES_NO_OPTION);
	}
}