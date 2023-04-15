package controller.menu.save.service;

import controller.menu.save.Path;
import controller.menu.save.view.InputView;
import controller.menu.save.view.OutputView;
import user.Player;

import java.io.*;

/**
 * 저장되어있는 유저 데이터를 불러오는 클래스
 */
public class LoadFile {

    private final InputView inputView;
    private final OutputView outputView;
    private Player player;

    public LoadFile() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public boolean loadFile(String fileName) {
        try (FileInputStream fis
                     = new FileInputStream(Path.USER_SAVE_PATH + "/" + fileName + ".sav")) {

            ObjectInputStream ois = new ObjectInputStream(fis);
            Player.load((Player) ois.readObject());

        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        } catch (ClassNotFoundException e) {
            return false;
        }
        return true;
    }

}
