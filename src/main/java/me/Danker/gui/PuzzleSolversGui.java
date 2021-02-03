package me.Danker.gui;

import me.Danker.DankersSkyblockMod;
import me.Danker.commands.ToggleCommand;
import me.Danker.handlers.ConfigHandler;
import me.Danker.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

public class PuzzleSolversGui extends GuiScreen {

	private int page;
	
	private GuiButton goBack;
	private GuiButton backPage;
	private GuiButton nextPage;
	private GuiButton riddle;
	private GuiButton trivia;
	private GuiButton blaze;
	private GuiButton onlyShowCorrectBlaze;
	private GuiButton creeper;
	private GuiButton water;
	private GuiButton ticTacToe;
	private GuiButton startsWith;
	private GuiButton selectAll;
	private GuiButton clickOrder;
	private GuiButton simon;
	private GuiButton blockClicks;
	private GuiButton itemFrameOnSeaLanterns;
	
	public PuzzleSolversGui(int page) {
		this.page = page;
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override
	public void initGui() {
		super.initGui();
		
		ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
		int height = sr.getScaledHeight();
		int width = sr.getScaledWidth();
		
		goBack = new GuiButton(0, 2, height - 30, 100, 20, "Go Back");
		backPage = new GuiButton(0, width / 2 - 100, (int) (height * 0.8), 80, 20, "< Back");
		nextPage = new GuiButton(0, width / 2 + 20, (int) (height * 0.8), 80, 20, "Next >");
		
		// Page 1
		riddle = new GuiButton(0, width / 2 - 100, (int) (height * 0.1), "Riddle Solver: " + Utils.getColouredBoolean(ToggleCommand.threeManToggled));
		trivia = new GuiButton(0, width / 2 - 100, (int) (height * 0.2), "Trivia Solver: " + Utils.getColouredBoolean(ToggleCommand.oruoToggled));
		blaze = new GuiButton(0, width / 2 - 100, (int) (height * 0.3), "Blaze Solver: " + Utils.getColouredBoolean(ToggleCommand.blazeToggled));
		onlyShowCorrectBlaze = new GuiButton(0, width / 2 - 100, (int) (height * 0.4), "Only Show Correct Blaze Hitbox: " + Utils.getColouredBoolean(ToggleCommand.onlyShowCorrectBlazeToggled));
		creeper = new GuiButton(0, width / 2 - 100, (int) (height * 0.5), "Creeper Solver: " + Utils.getColouredBoolean(ToggleCommand.creeperToggled));
		water = new GuiButton(0, width / 2 - 100, (int) (height * 0.6), "Water Solver: " + Utils.getColouredBoolean(ToggleCommand.waterToggled));
		ticTacToe = new GuiButton(0, width / 2 - 100, (int) (height * 0.7), "Tic Tac Toe Solver: " + Utils.getColouredBoolean(ToggleCommand.ticTacToeToggled));
		// Page 2
		startsWith = new GuiButton(0, width / 2 - 100, (int) (height * 0.1), "Starts With Letter Terminal Solver: " + Utils.getColouredBoolean(ToggleCommand.startsWithToggled));
		selectAll = new GuiButton(0, width / 2 - 100, (int) (height * 0.2), "Select All Color Terminal Solver: " + Utils.getColouredBoolean(ToggleCommand.selectAllToggled));
		clickOrder = new GuiButton(0, width / 2 - 100, (int) (height * 0.3), "Click in Order Terminal Helper: " + Utils.getColouredBoolean(ToggleCommand.clickInOrderToggled));
		simon = new GuiButton(0, width / 2 - 100, (int) (height * 0.4), "Simon Says Device Helper: " + Utils.getColouredBoolean(ToggleCommand.simonToggled));
		blockClicks = new GuiButton(0, width / 2 - 100, (int) (height * 0.5), "Block Wrong Clicks on Terminals: " + Utils.getColouredBoolean(ToggleCommand.blockWrongTerminalClicksToggled));
		itemFrameOnSeaLanterns = new GuiButton(0, width / 2 - 100, (int) (height * 0.6), "Ignore Arrows On Sea Lanterns: " + Utils.getColouredBoolean(ToggleCommand.itemFrameOnSeaLanternsToggled));
		
		switch (page) {
			case 1:
				this.buttonList.add(riddle);
				this.buttonList.add(trivia);
				this.buttonList.add(onlyShowCorrectBlaze);
				this.buttonList.add(blaze);
				this.buttonList.add(creeper);
				this.buttonList.add(water);
				this.buttonList.add(ticTacToe);
				this.buttonList.add(nextPage);
				break;
			case 2:
				this.buttonList.add(startsWith);
				this.buttonList.add(selectAll);
				this.buttonList.add(clickOrder);
				this.buttonList.add(simon);
				this.buttonList.add(blockClicks);
				this.buttonList.add(itemFrameOnSeaLanterns);
				this.buttonList.add(backPage);
				break;
		}
		this.buttonList.add(goBack);
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void actionPerformed(GuiButton button) {
		if (button == goBack) {
			DankersSkyblockMod.guiToOpen = "dankergui1";
		} else if (button == backPage) {
			Minecraft.getMinecraft().displayGuiScreen(new PuzzleSolversGui(page - 1));
		} else if (button == nextPage) {
			Minecraft.getMinecraft().displayGuiScreen(new PuzzleSolversGui(page + 1));
		} else if (button == riddle) {
			ToggleCommand.threeManToggled = !ToggleCommand.threeManToggled;
			ConfigHandler.writeBooleanConfig("toggles", "ThreeManPuzzle", ToggleCommand.threeManToggled);
			riddle.displayString = "Riddle Solver: " + Utils.getColouredBoolean(ToggleCommand.threeManToggled);
		} else if (button == trivia) {
			ToggleCommand.oruoToggled = !ToggleCommand.oruoToggled;
			ConfigHandler.writeBooleanConfig("toggles", "OruoPuzzle", ToggleCommand.oruoToggled);
			trivia.displayString = "Trivia Solver: " + Utils.getColouredBoolean(ToggleCommand.oruoToggled);
		} else if (button == blaze) {
			ToggleCommand.blazeToggled = !ToggleCommand.blazeToggled;
			ConfigHandler.writeBooleanConfig("toggles", "BlazePuzzle", ToggleCommand.blazeToggled);
			blaze.displayString = "Blaze Solver: " + Utils.getColouredBoolean(ToggleCommand.blazeToggled);
		} else if (button == onlyShowCorrectBlaze) {
			ToggleCommand.onlyShowCorrectBlazeToggled = !ToggleCommand.onlyShowCorrectBlazeToggled;
			ConfigHandler.writeBooleanConfig("toggles", "OnlyShowCorrectBlaze", ToggleCommand.onlyShowCorrectBlazeToggled);
			onlyShowCorrectBlaze.displayString = "Only Show Correct Blaze Hitbox: " + Utils.getColouredBoolean(ToggleCommand.onlyShowCorrectBlazeToggled);
		} else if (button == creeper) {
			ToggleCommand.creeperToggled = !ToggleCommand.creeperToggled;
			ConfigHandler.writeBooleanConfig("toggles", "CreeperPuzzle", ToggleCommand.creeperToggled);
			creeper.displayString = "Creeper Solver: " + Utils.getColouredBoolean(ToggleCommand.creeperToggled);
		} else if (button == water) {
			ToggleCommand.waterToggled = !ToggleCommand.waterToggled;
			ConfigHandler.writeBooleanConfig("toggles", "WaterPuzzle", ToggleCommand.waterToggled);
			water.displayString = "Water Solver: " + Utils.getColouredBoolean(ToggleCommand.waterToggled);
		} else if (button == ticTacToe) {
			ToggleCommand.ticTacToeToggled = !ToggleCommand.ticTacToeToggled;
			ConfigHandler.writeBooleanConfig("toggles", "TicTacToePuzzle", ToggleCommand.ticTacToeToggled);
			ticTacToe.displayString = "Tic Tac Toe Solver: " + Utils.getColouredBoolean(ToggleCommand.ticTacToeToggled);
		} else if (button == startsWith) {
			ToggleCommand.startsWithToggled = !ToggleCommand.startsWithToggled;
			ConfigHandler.writeBooleanConfig("toggles", "StartsWithTerminal", ToggleCommand.startsWithToggled);
			startsWith.displayString = "Starts With Letter Terminal Solver: " + Utils.getColouredBoolean(ToggleCommand.startsWithToggled);
		} else if (button == selectAll) {
			ToggleCommand.selectAllToggled = !ToggleCommand.selectAllToggled;
			ConfigHandler.writeBooleanConfig("toggles", "SelectAllTerminal", ToggleCommand.selectAllToggled);
			selectAll.displayString = "Select All Color Terminal Solver: " + Utils.getColouredBoolean(ToggleCommand.selectAllToggled);
		} else if (button == clickOrder) {
			ToggleCommand.clickInOrderToggled = !ToggleCommand.clickInOrderToggled;
			ConfigHandler.writeBooleanConfig("toggles", "ClickInOrderTerminal", ToggleCommand.clickInOrderToggled);
			clickOrder.displayString = "Click in Order Terminal Helper: " + Utils.getColouredBoolean(ToggleCommand.clickInOrderToggled);
		} else if (button == simon) {
			ToggleCommand.simonToggled = !ToggleCommand.simonToggled;
			ConfigHandler.writeBooleanConfig("toggles", "SimonSays", ToggleCommand.simonToggled);
			simon.displayString = "Simon Says Device Helper: " + Utils.getColouredBoolean(ToggleCommand.simonToggled);
		} else if (button == blockClicks) {
			ToggleCommand.blockWrongTerminalClicksToggled = !ToggleCommand.blockWrongTerminalClicksToggled;
			ConfigHandler.writeBooleanConfig("toggles", "BlockWrongTerminalClicks", ToggleCommand.blockWrongTerminalClicksToggled);
			blockClicks.displayString = "Block Wrong Clicks on Terminals: " + Utils.getColouredBoolean(ToggleCommand.blockWrongTerminalClicksToggled);
		} else if (button == itemFrameOnSeaLanterns) {
			ToggleCommand.itemFrameOnSeaLanternsToggled = !ToggleCommand.itemFrameOnSeaLanternsToggled;
			ConfigHandler.writeBooleanConfig("toggles", "IgnoreItemFrameOnSeaLanterns", ToggleCommand.itemFrameOnSeaLanternsToggled);
			itemFrameOnSeaLanterns.displayString = "Ignore Arrows On Sea Lanterns: " + Utils.getColouredBoolean(ToggleCommand.itemFrameOnSeaLanternsToggled);
		}
	}
	
}
