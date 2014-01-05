/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MichaelTestPackages;

import unquietcode.tools.flapi.Descriptor;
import unquietcode.tools.flapi.DescriptorMaker;

/**
 *
 * @author mfranchino
 */
public final class Generator {
	
	private static void generate(DescriptorMaker provider, String[] args) {
		Descriptor descriptor = provider.descriptor();
		descriptor.writeToFolder(args[0]);
	}
	
	public static void main(String[] args) {
		generate(new TestFlapi(), args);
	}
	
	
}
