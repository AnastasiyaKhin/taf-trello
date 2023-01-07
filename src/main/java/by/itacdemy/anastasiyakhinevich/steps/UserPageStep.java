package by.itacdemy.anastasiyakhinevich.steps;

import by.itacdemy.anastasiyakhinevich.page.UserPage;

public class UserPageStep extends UserPage {
    public void createBoard(String titleBoard) {
        createNewBoard()
                .addBoardTitle(titleBoard)
                .confirmCreateBoard();
    }

    public void createCard(String titleCard, String description) {
        addCardTitle(titleCard)
                .addCard()
                .changeCard()
                .addCardDescription(description)
                .saveDescriptionCard()
                .closeCard();
    }

    public void refactorCardOnBoard(String comment) {
        clickExistentCard()
                .addCommentOnCard(comment)
                .clickSaveComment()
                .closeCard();
    }

    public void closeCardAfterRefactor() {
        closeCard();
    }

    public void deleteBoard() {
        if (isBoardExist()) {
            clickOnActiveBoard()
                    .clickMenuForDelete()
                    .clickCloseBoard()
                    .clickConfirmClose()
                    .clickDeleteBoard()
                    .clickConfirmDelete();
        }
    }

    public String getTitleBoard() {
        return getActualTitleBoard();
    }

    public String getTitleCard() {
        return getActualTitleCard();
    }

    public String getCommentFromCard() {
        clickExistentCard();
        return getComment();
    }

    public boolean isActualBoardExist() {
        isBoardExist();
        return false;
    }
}

