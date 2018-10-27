package com.eplusing.designpattern.builder;

import java.util.Iterator;
import java.util.List;

import com.eplusing.designpattern.builder.product.Media;
import com.eplusing.designpattern.builder.product.MediaItem;

public class MediaDirector {
	private MediaBuilder mb;

	public MediaDirector(MediaBuilder mb) {
		this.mb = mb; // 具有策略模式相似特征的
	}

	public Media produceMedia(List input) {
		mb.buildBase();
		for (Iterator it = input.iterator(); it.hasNext();)
			mb.addMediaItem((MediaItem) it.next());
		return mb.getFinishedMedia();
	}
}
