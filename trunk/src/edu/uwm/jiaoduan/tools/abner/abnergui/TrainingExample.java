package edu.uwm.jiaoduan.tools.abner.abnergui;

/* ****************************************************************

 Copyright (C) 2004 Burr Settles, University of Wisconsin-Madison,
 Dept. of Computer Sciences and Dept. of Biostatistics and Medical
 Informatics.

 This file is part of the "ABNER (A Biomedical Named Entity
 Recognizer)" system. It requires Java 1.4. This software is
 provided "as is," and the author makes no representations or
 warranties, express or implied. For details, see the "README" file
 included in this distribution.

 This software is provided under the terms of the Common Public
 License, v1.0, as published by http://www.opensource.org. For more
 information, see the "LICENSE" file included in this distribution.

 **************************************************************** */

/*
 Simple example of how to use ABNER's API to train a new CRF model.
 */

import edu.uwm.jiaoduan.Messages;
import edu.uwm.jiaoduan.i2b2.utils.Timer;
import edu.uwm.jiaoduan.tools.abner.*;

import java.io.*;
import java.lang.*;
import java.util.*;

public class TrainingExample {

	public static void main(String[] args) {
		// String[] tags = {"M",
		// "DO",
		// "F",
		// "AM",//Allergy Medicine
		// "AMR"//Allergy Medicine Reaction
		// };
		Timer tm=new Timer("training model");
		if (args.length > 0)
			Messages.setUseRuleBundle(true);

		String[] tags = Messages.getString("JiaoDuan.i2b2.CRFModel.Annotation.Tags").split(",");
//
//
//		// if (args.length != 2) {
//		// System.err.println("java TrainingExample 'train.file' 'model.file'");
//		// System.exit(1);
//		// }
//		// t.train(args[0], args[1], new String[]{"PROTEIN"});
//		// t.train(args[0], args[1]);
//
//		// String trainFile = "./CRFmodel/i2b2medicine.train";
//		String trainFile = Messages.getString("lancet147.huge.train");
//		
//		String modelFile = Messages.getString("lancet147.huge.train.model");
		
//		String[] tags = {"deeplink"};
		Trainer t = new Trainer();

		String trainFile = "./lsdb/lsdbsingle.train";
		String modelFile = "./CRFmodel/afterFixBug/lsdb.model";
		// t.train(args[0], args[1], tags);
		t.train(trainFile, modelFile, tags);
		tm.outTime(System.out);
	}
}
