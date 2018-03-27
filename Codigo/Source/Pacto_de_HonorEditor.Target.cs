// Fill out your copyright notice in the Description page of Project Settings.

using UnrealBuildTool;
using System.Collections.Generic;

public class Pacto_de_HonorEditorTarget : TargetRules
{
	public Pacto_de_HonorEditorTarget(TargetInfo Target) : base(Target)
	{
		Type = TargetType.Editor;

		ExtraModuleNames.AddRange( new string[] { "Pacto_de_Honor" } );
	}
}
